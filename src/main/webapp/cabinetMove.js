$(document).ready(function() {
    var magazine = null;
    $.get('magazines', function(data) {
        if (data != '') {
            magazine = data;
        }
        debugger;
    }).done(function() {
        var cardsContect = "";
        jQuery.each(magazine, function(i, value) {
            cardsContect += "<div class='col-sm-4'> <div class = 'card'> <div class = 'image' > </div> <div class = 'card-inner' ><div class = 'header' ><h2> " + value.name + " </h2> <h2 > " + value.price + " </h2> </div> <div class ='content' > <a href='product?id=" + value.id + "'>link</a>  <p> " + value.information + " </p>  </div> </div > </div> </div> ";
        })
        $('#cabinet-magazine').html(cardsContect);

    })

})