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

$(function () {
    $('.navbar-collapse-button').click(function () {
        if ($(this).hasClass('menu-show')) {
            $('.sidebar').animate({
                left: "-=300"
            }, 0, function () {
                $('.main').removeClass('main-show').addClass('main-hide');
            });
            $(this).removeClass('menu-show').addClass('menu-hide');
        } else {
            $(".sidebar").animate({
                left: "+=300"
            }, 0, function () {
                $('.main').removeClass('main-hide').addClass('main-show');
            });
            $(this).removeClass('menu-hide').addClass('menu-show');
        }
    })
})