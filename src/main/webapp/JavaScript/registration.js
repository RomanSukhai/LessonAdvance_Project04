$(document).ready(function() {
    $('.btn.btn-primary.btn-block.fa-lg.gradient-custom-2.mb-3.my-gradient2#registration').click(function() {


        var emailUser = $('form input.form-control#emailUser').val();
        var nameUser = $('form input.form-control#nameUser').val();
        var passwordUser = $('form input.form-control#passwordUser').val();
        var passwordUser_conf = $('form input.form-control#passwordUser_conf').val();

        var userRegistration = {
            emailUser: emailUser,
            nameUser: nameUser,
            passwordUser: passwordUser
        }
        debugger;
        if (emailUser == '' || nameUser == '' || passwordUser == '' || passwordUser_conf == '') {
            $('.alert.alert-danger.w-25').addClass('disp-unnone')
            $('.alert.alert-danger.w-25').delay(5000).slideUp(300);
        } else if (passwordUser.length < 8) {
            $('.alert.alert-warning.w-25').addClass('disp-unnone')
            $('.alert.alert-warning.w-25').delay(5000).slideUp(300);
        } else if (!passwordUser.match(passwordUser_conf)) {
            $('.alert.alert-warning.w-25#confirm').addClass('disp-unnone')
            $('.alert.alert-warning.w-25#confirm').delay(5000).slideUp(300);
        } else {
            debugger;
            $('.alert.alert-success.w-25').addClass('disp-unnone')
            $('.alert.alert-success.w-25').delay(5000).slideUp(300);
            $.post('exit', userRegistration, function(data) {
                if (data == 'You have Successful Registration...') {
                    $('form')[0].reset();
                }
                var customUrl = '';
                debugger;
                var UrlContent = window.location.href.split('/');
                console.log(UrlContent);
                for (let i = 0; i < UrlContent.length - 1; i++) {
                    customUrl += UrlContent[i] + '/';
                }
                customUrl += data.destinationUrl;
                debugger;
                window.location = customUrl;
                console.log(email)

            })
        }
    })
    $('#login').click(function() {
        var emailUser = $('form input.form-control#emailUser').val();
        var passwordUser = $('form input.form-control#passwordUser').val();

        debugger;
        if (emailUser == '' || passwordUser == '') {
            $('.alert.alert-danger.w-25').addClass('disp-unnone')
            $('.alert.alert-danger.w-25').delay(5000).slideUp(300);
        } else if (passwordUser.length < 8) {
            $('.alert.alert-warning.w-25').addClass('disp-unnone')
            $('.alert.alert-warning.w-25').delay(5000).slideUp(300);
        }
        debugger;
        var userLogin = {
            emailUser: emailUser,
            passwordUser: passwordUser
        }
        debugger;
        $.post('login', userLogin, function(data) {
            var customUrl = '';
            var email = data.UserEmail;
            if (email == null) {
                $('.alert.alert-warning2.w-25').addClass('disp-unnone')
                $('.alert.alert-warning2.w-25').delay(5000).slideUp(300);
            } else {
                debugger;
                var UrlContent = window.location.href.split('/');
                console.log(UrlContent);
                for (let i = 0; i < UrlContent.length - 1; i++) {
                    customUrl += UrlContent[i] + '/';
                }
                customUrl += data.destinationUrl;
                debugger;
                window.location = customUrl;
                console.log(email)
            }
        })

    })
})