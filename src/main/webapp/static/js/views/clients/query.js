/**
 * Created by Guil on 5/2/2016.
 */
$(document).ready(function () {
    util.activeNavMenuLiById('#nav-menu-li-clients');
    $.validate({
        lang: 'es',
        modules : 'date'
    });
});