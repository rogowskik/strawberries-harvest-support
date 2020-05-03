'use strict';

(function () {
    function init() {
        var router = new Router([
            new Route('home', 'home.html', true, 'doOnHomeLoad'),
            new Route('rates', 'rates.html', false, 'doOnRatesLoad'),
            new Route('reports', 'reports.html', false, 'doOnReportsLoad')
        ]);
    }
    init();
}());
