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
    A.io.request("http://meteo.a-revolta.es/cumulus7.json", {
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
    A.all('div[data-json]').each(function () {
        var key = this.getAttribute('data-json');
        var value = json[key];
        this.html(value);
    });
}