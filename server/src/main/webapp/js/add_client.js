/**
 * scripts for page add client
 */

$(function() {
	$("#includedContent").load("../header.html");
	$("#accordion").accordion({
		heightStyle : "content"
	});
	$("#raisonAchat").change(function() {
		if (this.value === "7") {
			$("#tr_raisonsChang").show();

			$("#tr_autreOp").hide();
		} else if (this.value ==="8") {
			$("#tr_raisonsChang").hide();
			$("#tr_autreOp").show();

		} else {

			$("#tr_raisonsChang").hide();
			$("#tr_autreOp").hide();
		}
	});

	$("#idType").change(function() {
		if (this.value === "cin") {
			$("#label_idnumber").show();

			$("#idNumber").show();
		} else if (this.value === "pass") {
			$("#label_idnumber").hide();

			$("#idNumber").hide();
		}

	});

	$("#offersAccor").accordion({
		heightStyle : "content"
	});
	$("#nivscoAccomp").buttonset();
	$("#situation_achat").buttonset();
	$("#situation_achat").change(function() {
		
		
		if ($("#pour_offrir").is(':checked')) {
			$("#infos_autre_utilisateur").show();

		} else {
			$("#infos_autre_utilisateur").hide();

		}
	});
	$("#etatradioAccomp").buttonset();
	$("#lienParente").buttonset();
	$("#civilite").buttonset();
	$("#civiliteUtilisateur").buttonset();
	$("#etatradio").buttonset();
	$("#raisonChoix").buttonset();
	$("#operateurRadio").buttonset();
	$("#autreOperateurRadio").buttonset();

	$("#nivsco").buttonset();
	$("#dateNaissance").datepicker({
		dateFormat : "yy-mm-dd",
		yearRange : "1900:2010",
		changeMonth : true,
		changeYear : true
	});
	$("#dateNaissanceUtilisateur").datepicker({
		dateFormat : "yy-mm-dd",
		yearRange : "1900:2010",
		changeMonth : true,
		changeYear : true
	});
	$("#dialogOffers").dialog({
		autoOpen : false,
		height : 500,
		width : 800,
		modal : true,

		close : function() {

		}
	});

});

$(document).ready(

		function() {
			// lorsque je soumets le formulaire
			$('#cutomerForm').on(
					'submit',
					function() {
						var valid = true;
						
						if( jQuery.trim($("#name").val()).length==0 ) {
							valid = false;
							$("label[for='name']").css({color: "red"});
							}
						else{
							$("label[for='name']").css({color: "green"});
						}
							if ( jQuery.trim($("#dateNaissance").val()).length==0 ) {
								valid = false;
								$("label[for='dateNaissance']").css({color: "red"});
							}
							else
								$("label[for='dateNaissance']").css({color: "green"});
							
							
							if(!valid)
								return valid;
						
						// je récupère les valeurs
						var customer = new Object();
						customer.dateNaissance = $('#dateNaissance').val();
						customer.name = $('#name').val();
						var birthDate = $('#dateNaissance').datepicker(
								"getDate");

						var day = birthDate.getDay();
						var month = birthDate.getMonth();
						var year = birthDate.getYear();

						var now = new Date();
						var nowMonth = now.getMonth() + 1;
						var nowYear = now.getYear();
						var result = nowYear - year;

						if (month > nowMonth) {
							result--;
						} else if (month == nowMonth) {
							var nowDay = now.getDate();

							if (day > nowDay) {
								result--;
							}
						}
						customer.age = result;
						
						//var cutomerJson = JSON.stringify(customer);
						
						var frm = $( this ).serializeArray();
						var customerJson = '{';
						console.log(frm);
						$.each( frm, function( key, value ) {
							 customerJson +=' "'+value.name+'" : "'+value.value+'" , ';
							});
						customerJson=customerJson.substring(0, customerJson.length-2)+'}';
						
						
						$.ajax({
							url : $(this).attr('action'),
							type : $(this).attr('method'),
							data : customerJson,
							dataType : "json",
							contentType : "json",

							success : function(json) {
								
								$("#offersAccor").empty();
								$("#dialogOffers").dialog("open");
								$.each(json, function(i, item) {

									$("#offersAccor").append(
											"<h3>" + item.offerName
													+ "</h3><div >"
													+ item.description
													+ "</div>");

								});
								$("#offersAccor").accordion("refresh");
								

							},
							error : function() {
								alert("fail :-(");
							}
						});

						return false; // j'empêche le navigateur de soumettre
						// lui-même le formulaire
					});
		});