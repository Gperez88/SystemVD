/**
 * Created by Guil on 5/2/2016.
 */
$(document).ready(function () {
    util.activeNavMenuLiById('#nav-menu-li-clients');
    $.validate({
        lang: 'es',
        modules : 'date'
    });

    $('#removeClientModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        modal.find('.modal-body input').val(recipient)
    })
});