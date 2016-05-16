/**
 * Created by Guil on 5/2/2016.
 */
$(document).ready(function () {
    util.activeNavMenuLiById('#nav-menu-li-sale-sell');
    $('#sub-item-1').addClass('children collapse in');

    $("#autocomplete").autocomplete({
        source: function (request, response) {
            $.getJSON("/clientes/otenerNombreClientes?", {
                value: request.term
            }, response);
        }
    });

    //$('#productSelect').change(function () {
    //    $.get('/inventario/productos/obtenerPrecio',
    //        {productId: $(this).val()})
    //        .done(function (data) {
    //                $('#unitPrice').val(data);
    //                calculateTotalPrice();
    //            }
    //        )
    //});
    //
    //$('#quantity').change(function () {
    //    calculateTotalPrice();
    //});
    //
    //function calculateTotalPrice() {
    //    var quantity = $('#quantity').val();
    //    var unitPrice = $('#unitPrice').val();
    //
    //    var totalPrice = unitPrice * quantity;
    //
    //    $('#totalPrice').val(totalPrice);
    //}
});