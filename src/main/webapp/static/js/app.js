/**
 * Created by Guil on 4/30/2016.
 */

/**
 * Utility
 */
function util() {
}

util.activeNavMenuLiById = function (navMenuLiId) {
    $('ul.nav li').click(function () {
        $(this).removeClass('active');
    });

    $(navMenuLiId).addClass('active');
}