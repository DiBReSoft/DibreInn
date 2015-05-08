/**
 * Created by nakayama on 1/17/15.
 */
$(document).ready(
    function(){
        //function showPFPJBox() {
        //    erase = typeof erase !== 'undefined' ? erase : false;
        //
        //    var value =  $("input:radio[name=grouppfpj]:checked").val();
        //
        //    if(value == 'pf'){
        //        showFieldset('pf-info-fieldset');
        //    }else if(value == 'pj'){
        //        showFieldset('pj-info-fieldset');
        //    }else{
        //        return false;
        //    }
        //}

        //function showBox(id) {
        //    $('.widget-box.visible').removeClass('visible');
        //    $('#'+id).addClass('visible');
        //}
        //
        //function showFieldset(id) {
        //    $('.form-fieldset.visible').removeClass('visible');
        //    $('#'+id).addClass('visible');
        //}

        //$('.back-to-login-link').click(
        //    function(){
        //        showBox('login-box');
        //    }
        //);

        //$('.forgot-password-link').click(
        //    function(){
        //        showBox('forgot-box');
        //    }
        //);

        $.mask.definitions['~']='[+-]';
        $('.input-mask-date').mask('99/99/9999');
        $('.input-mask-cpf').mask('999.999.999-99');
        $('.input-mask-cnpj').mask('99.999.999/9999-99');
        $('.input-mask-cep').mask('99999-999');
        $('.input-mask-phone').mask('(99)9999-9999');
        $('.input-mask-mobile').mask('(99)9999-9999?9').focusout(function(){
                var phone, element;
                element = $(this);
                element.unmask();
                phone = element.val().replace(/\D/g, '');
                if(phone.length > 10) {
                    element.mask("(99) 99999-999?9");
                } else {
                    element.mask("(99) 9999-9999?9");
                }
            }
        ).trigger('focusout');


        //var validator = $('#register-form').validate(
        //    {
        //        errorElement: 'span',
        //        errorClass: 'help-inline',
        //        focusInvalid: false,
        //        rules: {
        //            email: {
        //                required: true,
        //                email:true
        //            },
        //            repeatemail: {
        //                required: true,
        //                equalTo: "#email1"
        //            },
        //            password: {
        //                required: true,
        //                minlength: 6
        //            },
        //            repeatpassword: {
        //                required: true,
        //                equalTo: "#password"
        //            },
        //            grouppfpj: 'required',
        //            agree: 'required',
        //            cnh: {
        //                required: true,
        //                number: true
        //            },
        //            firstname: {
        //                required: true
        //            },
        //            lastname: {
        //                required: true
        //            },
        //            dateofbirth: {
        //                required: true
        //            },
        //            cpf: {
        //                required: true
        //            },
        //            cnpj: {
        //                required: true
        //            },
        //            razaosocial: {
        //                required: true
        //            },
        //            cep: {
        //                required: true
        //            },
        //            number: {
        //                required: true
        //            }
        //        },
        //
        //        messages: {
        //            email: {
        //                required: "Por favor forneça um email.",
        //                email: "Por favor forneça um email válido."
        //            },
        //            repeatemail: {
        //                required: "Este campo é obrigatório.",
        //                email: "Por favor forneça um email válido.",
        //                equalto: "Os emails devem coincidir."
        //            },
        //            password: {
        //                required: "Por favor forneça uma senha.",
        //                minlength: "Sua senha deve ter mais que 6 caracteres."
        //            },
        //            repeatpassword: {
        //                required: "Este campo é obrigatório.",
        //                equalto: "As senha devem coincidir."
        //            },
        //            grouppfpj: "Por favor escolha uma modalidade de conta.",
        //            agree: "Por favor aceite nossos termos de serviço."
        //        },
        //
        //        invalidHandler: function (event, validator) {
        //
        //        },
        //
        //        highlight: function (e) {
        //            $(e).closest('.control-group').removeClass('info').addClass('error');
        //        },
        //
        //        success: function (e) {
        //            $(e).closest('.control-group').removeClass('error').addClass('info');
        //            $(e).remove();
        //        },
        //
        //        errorPlacement: function (error, element) {
        //            if(element.is(':checkbox') || element.is(':radio')) {
        //                var controls = element.closest('.controls');
        //                if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
        //                else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
        //            }
        //            else error.insertAfter(element);
        //        }
        //    }
        //);

        //function validateUserInfo(){
        //   return  validator.element( $('#signup-form').find('input[name=email]')) &&
        //           validator.element( $('#signup-form').find('input[name=repeatemail]')) &&
        //           validator.element( $('#signup-form').find('input[name=password]')) &&
        //           validator.element( $('#signup-form').find('input[name=repeatpassword]')) &&
        //           validator.element( $('#signup-form').find('input[name=grouppfpj]')) &&
        //           validator.element( $('#signup-form').find('input[name=agree]'));
        //}
        //
        //function validatePFPJInfo(){
        //    var value =  $("input:radio[name=grouppfpj]:checked").val();
        //
        //    if(value == 'pf'){
        //        return validator.element( $('#signup-form').find('input[name=cnh]')) &&
        //           validator.element( $('#signup-form').find('input[name=firstname]')) &&
        //           validator.element( $('#signup-form').find('input[name=lastname]')) &&
        //           validator.element( $('#signup-form').find('input[name=dateofbirth]')) &&
        //           validator.element( $('#signup-form').find('input[name=cpf]'));
        //    }else if(value == 'pj'){
        //        return validator.element( $('#signup-form').find('input[name=cnpj]')) &&
        //           validator.element( $('#signup-form').find('input[name=razaosocial]'));
        //    }
        //}

        //$('#fuelux-wizard').ace_wizard().on('change' ,
        //    function(e, info){
        //        if(info.step == 1) {
        //            if(!validateUserInfo())
        //                return false;
        //
        //            return showPFPJBox(true);
        //        }else if(info.step == 2){
        //            if(info.direction == "next") {
        //                if(!validatePFPJInfo())
        //                    return false;
        //
        //                showFieldset('address-info-fieldset');
        //            }else{
        //                showFieldset('user-info-fieldset');
        //            }
        //        }else if(info.step == 3){
        //             showPFPJBox()
        //        }
        //    }
        //).on('finished',
        //    function(e){
        //        if($("#signup-form").valid()) {
        //            var cpf = $('#signup-form').find('input[name=cpf]').mask();
        //            var cnpj = $('#signup-form').find('input[name=cnpj]').mask();
        //            var cep = $('#signup-form').find('input[name=cep]').mask();
        //
        //            $('#signup-form').find('input[name=cpf]').val(cpf);
        //            $('#signup-form').find('input[name=cnpj]').val(cnpj);
        //            $('#signup-form').find('input[name=cep]').val(cep);
        //            $('#signup-form').find('input[name=address]').removeAttr('disabled');
        //            $('#signup-form').find('input[name=city]').removeAttr('disabled');
        //            $('#signup-form').find('input[name=bairro]').removeAttr('disabled');
        //            $('#signup-form').find('input[name=state]').removeAttr('disabled');
        //            $("#signup-form").submit();
        //        }
        //    }
        //).on('stepclick',
        //    function(e){
        //        return false;//prevent clicking on steps
        //    }
        //);

        //$("#cep-input").focusout(
        //    function(){
        //        var cep = $(this).mask();
        //        var apiurl = "http://cep.correiocontrol.com.br/";
        //        apiurl = apiurl + cep + ".json";
        //        $("#login-overlay").show();
        //
        //        $.getJSON(apiurl, function(data)
        //        {
        //            $("#login-overlay").hide();
        //
        //            if(data.erro == "True")
        //            {
        //                $('#signup-form').find('input[name=address]').val("");
        //                $('#signup-form').find('input[name=bairro]').val("");
        //                $('#signup-form').find('input[name=city]').val("");
        //                $('#signup-form').find('input[name=state]').val("");
        //                return;
        //            }
        //
        //            $('#signup-form').find('input[name=address]').val(data.logradouro);
        //            $('#signup-form').find('input[name=bairro]').val(data.bairro);
        //            $('#signup-form').find('input[name=city]').val(data.localidade);
        //            $('#signup-form').find('input[name=state]').val(data.uf);
        //        }).fail(function()
        //        {
        //            $("#login-overlay").hide();
        //            $('#signup-form').find('input[name=address]').val("");
        //            $('#signup-form').find('input[name=bairro]').val("");
        //            $('#signup-form').find('input[name=city]').val("");
        //            $('#signup-form').find('input[name=state]').val("")
        //        });
        //    }
        //);

        //$("#agree-modal").hide();

        var loginForm = $('#login-form');

        var registerForm = $('#register-form');
        var registerValidator = registerForm.validate(
            {
                errorElement: 'span',
                errorClass: 'help-inline',
                focusInvalid: false,
                rules: {
                    email: {
                        required: true,
                        email:true
                    },
                    repeatemail: {
                        required: true,
                        equalTo: "#email1"
                    },
                    name: {
                        required: true
                    },
                    phone: {
                        required: true
                    }
                },

                messages: {
                    name: {
                        required: "Por favor forneça seu nome completo."
                    },
                    phone: {
                        required: "Por favor forneça um número para contato."
                    },
                    email: {
                        required: "Por favor forneça um email.",
                        email: "Por favor forneça um email válido."
                    },
                    repeatemail: {
                        required: "Este campo é obrigatório.",
                        email: "Por favor forneça um email válido.",
                        equalto: "Os emails devem coincidir."
                    }
                },

                invalidHandler: function (event, validator) {

                },

                highlight: function (e) {
                    $(e).closest('.control-group').removeClass('info').addClass('error');
                },

                success: function (e) {
                    $(e).closest('.control-group').removeClass('error').addClass('info');
                    $(e).remove();
                },

                errorPlacement: function (error, element) {
                    if(element.is(':checkbox') || element.is(':radio')) {
                        var controls = element.closest('.controls');
                        if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
                        else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
                    }
                    else error.insertAfter(element);
                }
            }
        );

        jQuery.extend(jQuery.validator.messages, {
            equalTo: "Os campos devem coincidir."
        });

        function validateRegisterInfo(){
            return  registerValidator.element(registerForm.find('input[name=name]')) && registerValidator.element(registerForm.find('input[name=email]')) && registerValidator.element(registerForm.find('input[name=repeatemail]')) && registerValidator.element(registerForm.find('input[name=phone]'));
        }

        $('#send-register-form').click(
            function(){
                if(validateRegisterInfo()) {
                    $.ajax(
                        {
                            url: 'http://docs.google.com/forms/d/1X-SVMCA-cGNTJ5B6xytEPTZRA7jHJFSxLWE-H4YAtkg/formResponse',
                            type: 'POST',
                            data: {
                                "entry.1599408722": $('input[name=name]').val(),
                                "entry.1970496500": $('input[name=email]').val(),
                                "entry.729989925": $('input[name=phone]').val()
                            },
                            dataType: "xml",
                            statusCode: {
                                0: function (){

                                    $('input[name=name]').val("");
                                    $('input[name=email]').val("");
                                    $('input[name=phone]').val("");
                                    $('input[name=repeatemail]').val("");
                                    $("#register-form").append('<div class="alert alert-success" style="margin-top: 10px">Cadastro efetuado com sucesso!</div>');
                                    window.setTimeout(function() { $(".alert").alert('close'); }, 5000);
                                },
                                200: function (){
                                    $('input[name=name]').val("");
                                    $('input[name=email]').val("");
                                    $('input[name=phone]').val("");
                                    $('input[name=repeatemail]').val("");
                                    $("#register-form").append('<div class="alert alert-success" style="margin-top: 10px">Cadastro efetuado com sucesso!</div>');
                                    window.setTimeout(function() { $(".alert").alert('close'); }, 5000);
                                }
                            }
                        }
                    );
                }
            }
        );
    }
);