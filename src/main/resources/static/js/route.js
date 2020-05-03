'use stict';

function Route(name, htmlName, defaultRoute, onLoadFunction) {
    try {
        if(!name || !htmlName) {
            throw 'error: name and htmlName params are mandatories';
        }
        this.constructor(name, htmlName, defaultRoute, onLoadFunction);
    } catch (e) {
        console.error(e);
    }
}

Route.prototype = {
    name: undefined,
    htmlName: undefined,
    default: undefined,
    onLoadFunction: undefined,
    constructor: function (name, htmlName, defaultRoute, onLoadFunction) {
        this.name = name;
        this.htmlName = htmlName;
        this.default = defaultRoute;
        this.onLoadFunction = onLoadFunction;
    },
    isActiveRoute: function (hashedPath) {
        return hashedPath.replace('#', '') === this.name; 
    }
}