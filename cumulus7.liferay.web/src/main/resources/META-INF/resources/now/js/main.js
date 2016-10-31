AUI().ready('node', 'aui-io-request',
        function (A) {
            A.all('.observations-json-link').each(
                    function () {
                        this.on('click',
                                function () {
                                    getJSON(A);
                                });
                    });
            A.on('load',
                    function () {
                        getJSONValues(A);
                        setInterval(function () {
                            getJSONValues(A);
                        }, 180000);
                    }
            );
        }
);

function getJSONValues(A) {
    A.io.request(A.one('.portlet-cumulus-now .now-json-link').getAttribute('data-href'), {
        dataType: 'json',
        on: {
            success: function () {
                var data = this.get('responseData');
                updateInfo(A, data);
            }
        }
    });
}

function updateInfo(A, json) {
    A.all('[data-json]').each(function () {
        var key = this.getAttribute('data-json');
        var unit = this.getAttribute('data-unit');
        var text = '';
        if(json[key] !== undefined) {
            text += json[key];
            if(unit !== undefined) {
                text += ' ' + unit;
            }
            this.html(text);
        }
    });
}