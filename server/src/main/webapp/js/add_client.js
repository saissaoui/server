/**
 * scripts for page add client
 */

$(function() {

	$("#includedContent").load("../header.jsp");
	$("#accordion").accordion({
		heightStyle : "content",
		collapsible : true,
		autoHeight : false
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
	$("#niveauScolaireUtilisateur").buttonset();
	$("#situation_achat").buttonset();
	$("#situation_achat").change(function() {

		if ($("#pour_offrir").is(':checked')) {
			$("#infos_autre_utilisateur").show();

		} else {
			$("#infos_autre_utilisateur").hide();

		}
	});
	$("#etatCivilUtilisateur").buttonset();
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
	$("#choseOffer").button().click(function(event) {
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
												color : "black"
											});
										}
										if (jQuery.trim($("#lastname").val()).length == 0) {
											valid = false;
											$("label[for='lastname']").css({
												color : "red"
											});
										} else {
											$("label[for='lastname']").css({
												color : "black"
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
														color : "black"
													});

										if (!($('#phone').val()

										.match(/^7\d{7}$/))
												&& !($('#phone').val()
														.match(/^3\d{7}$/))) {

											valid = false;
											$("label[for='phone']").css({
												color : "red"
											});

											$('#phone_error').show();
										} else {
											$("label[for='phone']").css({
												color : "black"
											});

											$('#phone_error').hide();
										}

										if (!($('#email').val()
												.match(/\S+@\S+\.\S+/))) {

											valid = false;
											$("label[for='email']").css({
												color : "red"
											});

											$('#email_error').show();
										} else {
											$("label[for='email']").css({
												color : "black"
											});

											$('#email_error').hide();
										}

										if (jQuery.trim($('#idType').val()) == "cin") {
											if (!$('#idNumber').val().match(
													/^\d{8}$/)) {

												valid = false;
												$("label[for='idNumber']").css(
														{
															color : "red"
														});
												$('#idnumber_error').show();
											} else {
												$("label[for='idNumber']").css(
														{
															color : "black"
														});

												
												$('#idnumber_error').hide();
											}
										} else {
											$("label[for='idNumber']").css({
												color : "black"
											});

										}

										if (jQuery.trim($("#ville").val()).length == 0) {
											valid = false;
											$("label[for='ville']").css({
												color : "red"
											});
										} else {
											$("label[for='ville']").css({
												color : "black"
											});
										}

										if (jQuery.trim($("#adress").val()).length == 0) {
											valid = false;
											$("label[for='adress']").css({
												color : "red"
											});
										} else {
											$("label[for='adress']").css({
												color : "black"
											});
										}
										if (jQuery.trim($("#codePostal").val()).length == 0) {
											valid = false;
											$("label[for='codePostal']").css({
												color : "red"
											});
										} else {
											$("label[for='codePostal']").css({
												color : "black"
											});
										}

										if (jQuery.trim($("#profession").val()).length == 0) {
											valid = false;
											$("label[for='profession']").css({
												color : "red"
											});
										} else {
											$("label[for='profession']").css({
												color : "black"
											});
										}
										if (jQuery.trim($("#revenu").val()).length == 0) {
											valid = false;
											$("label[for='revenu']").css({
												color : "red"
											});
										} else {
											$("label[for='revenu']").css({
												color : "black"
											});
										}
										console.log($("#situation_ligne")
												.val());
										if (jQuery.trim($("#situation_ligne")
												.val()).length == 0) {
											valid = false;
											$("label[for='situation_ligne']")
													.css({
														color : "red"
													});
										} else {
											$("label[for='situation_ligne']")
													.css({
														color : "black"
													});
											
											if (jQuery.trim($(
											"#situation_ligne").val()) == "second") {
												console.log(jQuery
												.trim($(
														'input[name=ancienOperateur]:radio:checked')
														.val()).length);
										if (jQuery
												.trim($(
														'input[name=ancienOperateur]:radio:checked')
														.val()).length == 0) {
											valid = false;
											$(
													"label[for='autreOperateurRadio']")
													.css({
														color : "red"
													});
										} else {
											
											if(jQuery.trim($(
											"#line_type").val().length)!=0)
											$(
													"label[for='autreOperateurRadio']")
													.css({
														color : "black"
													});
										}

									}
											
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
												color : "black"
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
												color : "black"
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
												color : "black"
											});
										}

										if ($("#raisonAchat").val() == 9) {
											if (jQuery.trim($("#lien_parente")
													.val()).length == 0) {
												valid = false;
												$("label[for='lien_parente']")
														.css({
															color : "red"
														});
											} else {
												$("label[for='lien_parente']")
														.css({
															color : "black"
														});
											}
											if (jQuery
													.trim($("#nomUtilisateur")
															.val()).length == 0) {
												valid = false;
												$("label[for='nomUtilisateur']")
														.css({
															color : "red"
														});
											} else {
												$("label[for='nomUtilisateur']")
														.css({
															color : "black"
														});
											}
											if (jQuery
													.trim($(
															"#prenomUtilisateur")
															.val()).length == 0) {
												valid = false;
												$(
														"label[for='prenomUtilisateur']")
														.css({
															color : "red"
														});
											} else {
												$(
														"label[for='prenomUtilisateur']")
														.css({
															color : "black"
														});
											}
											if (jQuery
													.trim($(
															"#dateNaissanceUtilisateur")
															.val()).length == 0) {
												valid = false;
												$(
														"label[for='dateNaissanceUtilisateur']")
														.css({
															color : "red"
														});
											} else {
												$(
														"label[for='dateNaissanceUtilisateur']")
														.css({
															color : "black"
														});
											}
											if (jQuery
													.trim($(
															'input[name=civiliteUtilisateur]:radio:checked')
															.val()).length == 0) {
												valid = false;
												$(
														"label[for='civiliteUtilisateur']")
														.css({
															color : "red"
														});
											} else {
												$(
														"label[for='civiliteUtilisateur']")
														.css({
															color : "black"
														});
											}
											console.log($("#situation_ligne")
													.val());
											

											if (jQuery.trim($(
													"#villeUtilisateur").val()).length == 0) {
												valid = false;
												$(
														"label[for='villeUtilisateur']")
														.css({
															color : "red"
														});
											} else {
												$(
														"label[for='villeUtilisateur']")
														.css({
															color : "black"
														});
											}
											if (jQuery.trim($(
													"#codePostalUtilisateur")
													.val()).length == 0) {
												valid = false;
												$(
														"label[for='codePostalUtilisateur']")
														.css({
															color : "red"
														});
											} else {
												$(
														"label[for='codePostalUtilisateur']")
														.css({
															color : "black"
														});
											}
											if (jQuery.trim($(
													"#gouvernoratUtilisateur")
													.val()).length == 0) {
												valid = false;
												$(
														"label[for='gouvernoratUtilisateur']")
														.css({
															color : "red"
														});
											} else {
												$(
														"label[for='gouvernoratUtilisateur']")
														.css({
															color : "black"
														});
											}
											if (jQuery
													.trim($(
															'input[name=niveauScolaireUtilisateur]:radio:checked')
															.val()).length == 0) {
												valid = false;
												$(
														"label[for='niveauScolaireUtilisateur']")
														.css({
															color : "red"
														});
											} else {
												$(
														"label[for='niveauScolaireUtilisateur']")
														.css({
															color : "black"
														});
											}
											if (jQuery.trim($(
													"#professionUtilisateur")
													.val()).length == 0) {
												valid = false;
												$(
														"label[for='professionUtilisateur']")
														.css({
															color : "red"
														});
											} else {
												$(
														"label[for='professionUtilisateur']")
														.css({
															color : "black"
														});
											}
											if (jQuery
													.trim($(
															'input[name=etatCivilUtilisateur]:radio:checked')
															.val()).length == 0) {
												valid = false;
												$(
														"label[for='etatCivilUtilisateur']")
														.css({
															color : "red"
														});
											} else {
												$(
														"label[for='etatCivilUtilisateur']")
														.css({
															color : "black"
														});
											}
											if (jQuery
													.trim($(
															"#revenuUtilisateur")
															.val()).length == 0) {
												valid = false;
												$(
														"label[for='revenuUtilisateur']")
														.css({
															color : "red"
														});
											} else {
												$(
														"label[for='revenuUtilisateur']")
														.css({
															color : "black"
														});
											}
											if (jQuery
													.trim($(
															"#adresseUtilisateur")
															.val()).length == 0) {
												valid = false;
												$(
														"label[for='adresseUtilisateur']")
														.css({
															color : "red"
														});
											} else {
												$(
														"label[for='adresseUtilisateur']")
														.css({
															color : "black"
														});
											}
										}
										
										if (jQuery
												.trim($(
														"#depenses")
														.val()).length == 0) {
											valid = false;
											$(
													"label[for='depenses']")
													.css({
														color : "red"
													});
										} else {
											$(
													"label[for='depenses']")
													.css({
														color : "black"
													});
										}
										
										if(($('#achatAccompagne').val()=="true")&&jQuery
												.trim($(
												'input[name=operateurAccompagnant]:radio:checked')
												.val()).length == 0){
											
											
											valid = false;
											$(
													"label[for='operateurRadio']")
													.css({
														color : "red"
													});
										} else {
											$(
													"label[for='operateurRadio']")
													.css({
														color : "black"
													});
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
																										+ "<input type='text' id='offerId' hidden='true' value='"
																										+ item.idoffer
																										+ "'>"
																										+ "<input id='choseOffer' onclick='addCustomer("
																										+ item.idoffer
																										+ ","
																										+ customerJson
																										+ ");' type='submit' value='Choisir cette offre'>"
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
function addCustomer(id, customerJson) {

	$.ajax({
		url : "../rest/customer/add/" + id,
		type : "POST",
		data : JSON.stringify(customerJson),
		dataType : "json",
		contentType : "json",
		success : function(json) {
			alert("Client ajouté avec l'identifiant " + json
					+ " et offre assignée avec succès");
			$('#cutomerForm').each(function() {
				this.reset();
			});
			$("#dialogOffers").dialog("close");

		},
		error : function() {
			alert("erreur d'ajout de client");
		}
	});

	console.log("add " + id);
}

$(document).on({
	ajaxStart : function() {
		console.log("start");
		$(".modal").css("display", "block");
	},
	ajaxStop : function() {
		console.log("stop");
		$(".modal").css("display", "none");
	}
});
