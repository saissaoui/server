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
		} else if (this.value === "8") {
			$("#tr_raisonsChang").hide();
			$("#tr_autreOp").show();

		} else {

			$("#tr_raisonsChang").hide();
			$("#tr_autreOp").hide();
		}
	});

	$("#offersAccor").accordion({
		heightStyle : "content"
	});
	$("#country").change(function() {
		if (this.value === "Tunisie") {
			$('#pass').hide();
		}

		else
			$('#pass').show();

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
	$("#lien_accompagnant").buttonset();
	$("#lien_accompagnant").change(function() {

		if ($("#non_acccomp").is(':checked')) {
			$("#achatAccompagne").val("false");

		} else {
			$("#achatAccompagne").val("true");

		}
	
	});
	$("#civilite").buttonset();
	$("#civiliteUtilisateur").buttonset();
	$("#etatradio").buttonset();
	$("#raisonChoix").buttonset();
	$("#operateurRadio").buttonset();
	$("#autreOperateurRadio").buttonset();

	$("#nivsco").buttonset();
	$("#dateNaissance").datepicker({
		dateFormat : "dd-mm-yy",
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

$(document)
		.ready(

				function() {
					// lorsque je soumets le formulaire
					$('#cutomerForm')
							.on(
									'submit',
									function() {
										var valid = true;

										if (jQuery.trim($("#name").val()).length == 0) {
											valid = false;
											$("label[for='name']").css({
												color : "red"
											});
										} else {
											$("label[for='name']").css({
												color : "green"
											});
										}
										if (jQuery.trim($("#dateNaissance")
												.val()).length == 0) {
											valid = false;
											$("label[for='dateNaissance']")
													.css({
														color : "red"
													});
										} else
											$("label[for='dateNaissance']")
													.css({
														color : "green"
													});
										
										if(!($('#phone').val().match(/^7\d{7}/))){
											valid = false;
											$("label[for='phone']").css({
												color : "red"
											});
											
											$('#phone_error').show();
										} else {
											$("label[for='phone']").css({
												color : "green"
											});

											$('#phone_error').hide();
										}
										
										

										if (jQuery
												.trim($('input[name=raisonChoix]:radio:checked').val()).length == 0) {
											valid = false;
											$("label[for='raisonChoix']").css({
												color : "red"
											});
										} else {
											$("label[for='raisonChoix']").css({
												color : "green"
											});
										}
										if (jQuery
												.trim($("#raisonAchat").val()).length == 0) {
											valid = false;
											$("label[for='raisonAchat']").css({
												color : "red"
											});
										} else {
											$("label[for='raisonAchat']").css({
												color : "green"
											});
										}
										if (jQuery
												.trim($("#gouvernorat").val()).length == 0) {
											valid = false;
											$("label[for='gouvernorat']").css({
												color : "red"
											});
										} else {
											$("label[for='gouvernorat']").css({
												color : "green"
											});
										}
										if ($("#raisonAchat").val() == 8) {
											if (jQuery
													.trim($('input[name=autreOperateur]:radio:checked')
															.val()).length == 0) {
												valid = false;
												$(
														"label[for='autreOperateurRadio']")
														.css({
															color : "red"
														});
											} else {
												$(
														"label[for='autreOperateurRadio']")
														.css({
															color : "green"
														});
											}
										}
										
										if (!valid){
											$("#error").show();
											return valid;
										}
										else
											$("#error").hide();
										// je récupère les valeurs
										var customer = new Object();
										customer.dateNaissance = $(
												'#dateNaissance').val();
										customer.name = $('#name').val();
										var birthDate = $('#dateNaissance')
												.datepicker("getDate");

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

										// var cutomerJson =
										// JSON.stringify(customer);

										var frm = $(this).serializeArray();
										var customerJson = '{';
										
										$.each(frm, function(key, value) {
											customerJson += ' "' + value.name
													+ '" : "' + value.value
													+ '" , ';
										});
										customerJson = customerJson.substring(
												0, customerJson.length - 2)
												+ '}';

										$
												.ajax({
													url : $(this)
															.attr('action'),
													type : $(this).attr(
															'method'),
													data : customerJson,
													dataType : "json",
													contentType : "json",

													success : function(json) {

														$("#offersAccor")
																.empty();
														$("#dialogOffers")
																.dialog("open");
														$
																.each(
																		json,
																		function(
																				i,
																				item) {

																			$(
																					"#offersAccor")
																					.append(
																							"<h3>"
																									+ item.offerName
																									+ "</h3><div >"
																									+ item.description
																									+ "</div>");

																		});
														$("#offersAccor")
																.accordion(
																		"refresh");

													},
													error : function() {
														alert("fail :-(");
													}
												});

										return false; // j'empêche le
										// navigateur de
										// soumettre
										// lui-même le formulaire
									});
				});