AUI().ready(
        'node',
        'liferay-portlet-url',
        'aui-io-request',
        'aui-progressbar',
        function (A) {
            A.all('.observations-json-link').each(
                    function () {
                        this.on('click',
                                function () {
                                    refreshData(A);
                                });
                    });
            A.on('load',
                    function () {
                        refreshData(A);
                        setInterval(function () {
                            refreshData(A);
                        }, 180000);
                    }
            );
        }
);

function refreshData(A) {
    var jsonURL = A.one('.observations-json-link').getAttribute('data-href');
    if (jsonURL) {
        A.io.request(jsonURL, {
            dataType: 'json',
            on: {
                success: function () {
                    var data = this.get('responseData');
                    // EXTERIOR TEMPERATURE
                    A.all('.temp').each(function () {
                        var value = data.temp.replace(',', '.');
                        var valueUnit = data.tempunit;
                        this.html(value + ' ' + valueUnit);
                    });
                    // INTERIOR TEMPERATURE
                    A.all('.intemp').each(function () {
                        var value = data.intemp.replace(',', '.');
                        var valueUnit = data.tempunit;
                        this.html(value + ' ' + valueUnit);
                    });
                    // EXTERIOR HUMIDITY
                    A.all('.hum').each(function () {
                        var value = data.hum.replace(',', '.');
                        var valueUnit = '%';
                        this.html(value + ' ' + valueUnit);
                    });
                    // INTERIOR HUMIDITY
                    A.all('.inhum').each(function () {
                        var value = data.inhum.replace(',', '.');
                        var valueUnit = '%';
                        this.html(value + ' ' + valueUnit);
                    });
                    // WIND SPEED
                    A.all('.wspeed').each(function () {
                        var value = data.wgust.replace(',', '.');
                        var valueUnit = data.windunit;
                        this.html(value + ' ' + valueUnit);
                    });
                    // CURRENT WIND DIRECTION
                    A.all('.currentwdir').each(function () {
                        var value = data.wgust.replace(',', '.');
                        var valueUnit = data.windunit;
                        this.html(value + ' ' + valueUnit);
                    });
                    // RAINFALL LAST HOUR
                    A.all('.rhour').each(function () {
                        var value = data.rhour.replace(',', '.');
                        var valueUnit = data.rainunit;
                        this.html(value + ' ' + valueUnit);
                    });
                    // TIME
                    A.all('.timehhmmss').each(function () {
                        var value = data.timehhmmss;
                        this.html(value);
                    });
                }
            }
        });
    }
}