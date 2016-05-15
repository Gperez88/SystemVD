/**
 * Created by Guil on 5/2/2016.
 */
$(document).ready(function () {
    util.activeNavMenuLiById('#nav-menu-li-sale-sell');
    $('#sub-item-1').addClass('children collapse in');

    $(function () {
        $("#autocomplete").autocomplete({
            source: function (request, response) {
                $.getJSON("/clientes/clientnames?", {
                    value: request.term
                }, response);
            }
        });
    });
});