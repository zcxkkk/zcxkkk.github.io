// ==UserScript==
// @name	Acfun Unreplaceable
// @author	googleGuard
// @version	1.1
// @include	http://www.acfun.tv/v/a*
// @run-at	document-start
// @grant	none
// ==/UserScript==
function hehe () {
    (function(f) {
        document.documentElement.appendChild(document.createElement('script')).textContent = '(' + f + ')()'
    })(function(){
        String.prototype.toStringT = String.prototype.toString;
        String.prototype.toString = function() {
            this == location.href && document.querySelector('#area-part-view a.btn.active').setAttribute('data-from', 'default');
            return this.toStringT()
        };
    });
}
