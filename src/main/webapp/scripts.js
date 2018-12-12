$(document).ready(function () {
    var form = $('#main_form');
    form.on('submit', function (event) {
        var a = $('#a').val();
        var b = $('#b').val();
        var c = $('#c').val();

        if ($.trim(b) == '') {
            console.log("B is empty, changed to 0");
            b = 0;
        }
        if ($.trim(c) == '') {
            console.log("C is empty, changed to 0");
            c = 0;
        }

        if ($.trim(a) != '') {
            if (!$.isNumeric(a) || !$.isNumeric(b) || !$.isNumeric(c)) {
                $('#dialog').html('Please, enter the numbers');
                event.preventDefault();
                return;
            } else {
                $('#dialog').html("Is ok");
            }
            $.post('calculate', {A: a, B: b, C: c}, function (data) {

                var a = data.a;
                var b = data.b;
                var c = data.c;
                var markup ="<tr><td>A = " + a + "; B = " + b + "; C = " + c + "</td>" +
                    "<td>" + data.ans + "</td>" +
                    "<td><input type='checkbox' name='record'></td></tr>";
                $('#History tbody').prepend(markup);
            });

            $("#delete-row").click(function(){
                $("#History tbody").find('input[name="record"]').each(function(){
                    if($(this).is(":checked")){
                        $(this).parents("tr").remove();
                    }
                });
            });
        }
        event.preventDefault();
    });
});