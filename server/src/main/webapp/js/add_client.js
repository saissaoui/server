/**
 * scripts for page add client
 */

$(function() {

	$("#includedContent").load("../header.jsp");
	$("#accordion").accordion({
		heightStyle : "content"
	});

	$("#raisonAchat").change(function() {

		if (this.value === "9") {

			$("#infos_autre_utilisateur").show();

		} else {
			$("#infos_autre_utilisateur").hide();

		}
	});

	$("#offersAccor").accordion({
		heightStyle : "content"
	});
	$("#country").change(function() {
		if (this.value === "Tunisie") {
			$('#pass').hide();
			$('#csj').hide();
			$('#cin').show();

		}

		else {
			$('#pass').show();
			$('#csj').show();
			$('#cin').hide();
		}
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
	$("#mode_utilisation").buttonset();
	$("#situation_ligne").change(function() {
		if (this.value === "rep") {
			$("#tr_raisonsChang").show();
			$("#tr_autreOp").hide();
		}

		else if (this.value === "second") {
			$("#tr_raisonsChang").hide();
			$("#tr_autreOp").show();
		} else {
			$("#tr_raisonsChang").hide();
			$("#tr_autreOp").hide();
		}
	});
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
	$("#autreOperateurRadio")
			.change(
					function() {
						$("#line_type").hide();
						$("#line_type").empty();
						var op = "";
						if ($("#autretun").is(':checked')) {
							op = "tunisiana";
						} else if ($("#autreorange").is(':checked')) {
							op = "orange";
						} else if ($("#autrett").is(':checked')) {
							op = "tt";
						}

						$
								.ajax({
									url : "../rest/offer/get/" + op,
									type : "GET",
									dataType : "json",
									contentType : "json",
									success : function(json) {

										sel = '<option selected="selected" value="">choisissez un type d\'offre</option>';

										$.each(json, function(i, item) {

											sel += "<option value="
													+ item.idoffer + ">"
													+ item.offerName
													+ "</option>";

										});
										$("#line_type").append(sel);
									},
									error : function() {
										alert("fail retrieving operators");
									}
								});
						$("#line_type").show();
					});
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
	$("#choseOffer").button()
    .click(function( event ) {
      console.log("click");
    });
	$("#loading").dialog({
		autoOpen : false,
		height : 500,
		width : 800,
		modal : true,

		close : function() {

		}
	}).on({
		ajaxStart : function() {
			console.log("start");
			$(this).dialog("open");
		},
		ajaxStop : function() {
			$(this).dialog("close");
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

										if (!($('#phone').val()
												.match(/^7\d{7}/))&&!($('#phone').val()
														.match(/^30\d{6}/))) {
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
												.trim($(
														'input[name=raisonChoix]:radio:checked')
														.val()).length == 0) {
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
													.trim($(
															'input[name=autreOperateur]:radio:checked')
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

										if (!valid) {
											$("#error").show();
											return valid;
										} else
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

														if (json.length == 0)
															// $("#no_offers").show();
															alert("Pas d'offres correspondant aux informations renseignées");
														else {
															$("#dialogOffers")
																	.dialog(
																			"open");
															$("#no_offers")
																	.hide();
															
															
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
																										+"<input type='text' id='offerId' hidden='true' value='"+item.idoffer+"'>"
																										+"<input id='choseOffer' onclick='addCustomer("+item.idoffer+","+customerJson+");' type='submit' value='Choisir cette offre'>"
																										+ "</div>");

																			});
														}
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
function addCustomer(id,customerJson){
	
	$.ajax({
		url : "../rest/customer/add/"+id,
		type : "POST",
		data : JSON.stringify(customerJson),
		dataType : "json",
		contentType : "json",
		success : function(json) {
			alert("Client ajouté avec l'identifiant "+json+" et offre assignée avec succès");
			$('#cutomerForm').each(function(){this.reset();});
			$("#dialogOffers").dialog("close");
			
		},
		error: function(){
			alert("erreur d'ajout de client");
		}
	});
	
	console.log("add "+id);
}

$(document).on({
	ajaxStart : function() {
		console.log("start");
		$(".modal").css("display","block");
	},
	ajaxStop : function() {
		console.log("stop");$(".modal").css("display","none");
	}
});