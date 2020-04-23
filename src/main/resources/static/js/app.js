'use strict';

(function () {
    function init() {
        var router = new Router([
            new Route('home', 'home.html', true),            
            new Route('rates', 'rates.html'),
            new Route('reports', 'reports.html')
        ]);
    }
    init();
}());
