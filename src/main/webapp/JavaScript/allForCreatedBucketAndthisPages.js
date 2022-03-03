$(document).ready(function() {
    $('section.py-5').remove()
    $('#magazine').click(function() {
        var name = $('form input.form-control#name').val();
        var pages = $('form input.form-control#pages').val();
        var information = $('form input.form-control#information').val();
        var price = $('form input.form-control#price').val();

        debugger;
        if (name == '' || pages == '' || information == '' || price == '') {
            $('.alert.alert-danger.w-25').addClass('disp-unnone')
            $('.alert.alert-danger.w-25').delay(5000).slideUp(300);
        }
        debugger;
        var magazineCreate = {
            name: name,
            pages: pages,
            information: information,
            price: price
        }
        debugger;
        $.post('product', magazineCreate, function(data) {
            var customUrl = '';
            var email = data.UserEmail;
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
    })
})