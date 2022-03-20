$(document).ready(function() {
    var magazine = null;
    $.get('bucket', function(data) {
        if (data != '') {
            magazine = data;
        }
        debugger;
    }).done(function() {
        var cardsContect = "<tr class='header'>" +
            "<th style='width:20%;'>Name</th>" +
            "<th style='width:20%;'>Description</th>" +
            "<th style='width:20%;'>Price</th>" +
            "<th style='width:20%;'>Create Date</th>" +
            "<th style='width:20%;'>Option</th>" +
            "</tr>";
        jQuery.each(magazine, function(i, value) {
            cardsContect += "<tr>" +
                "<td>" + value.name + "</td>" +
                "<td>" + value.information + "</td>" +
                "<td>" + value.price + "</td>" +
                "<td>" + value.purchase_date + "</td>" +
                "<td><button  onclick='droper(" + value.bucket_id + ")'>delete</button></td>";
        })
        $('#myTable').html(cardsContect);

    })




})

function droper(bucket_id) {
    var customURL = '';
    var urlContent = window.location.href.split('/');
    for (var i = 0; i < urlContent.lenght - 1; i++) {
        customURL += urlContent[i] + '/'
    }
    customURL += 'bucket?bucketId=' + bucket_id;

    $.ajax({
        url: customURL,
        type: 'DELETE',
        success: function(data) {
            if (data == 'Success') {
                location.reload();
            }
        }
    })
}