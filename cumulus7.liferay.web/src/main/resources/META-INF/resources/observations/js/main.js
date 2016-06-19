AUI().ready('node', 'aui-io-request',
        function (A) {
            A.all('.observations-json-link').each(
                    function () {
                        this.on('click',
                                function () {
                                    getJSON(A.one('.observations-json-link').getAttribute('data-href'));
                                });
                    });
            A.on('load',
                    function () {
                        getJSON(A.one('.observations-json-link').getAttribute('data-href'));
                        setInterval(function () {
                            getJSON(A.one('.observations-json-link').getAttribute('data-href'));
                        }, 180000);
                    }
            );
            function getJSON(jsonURL) {
                A.io.request(jsonURL, {
                    dataType: 'json',
                    on: {
                        success: function () {
                            var data = this.get('responseData');
                            updateWeather(data);
                        }
                    }
                });
            }
            function updateWeather(json) {
                A.all('.temp').each(function () {
                    var value = json.temp.replace(',', '.');
                    var valueUnit = json.tempunit;
                    this.html(value + ' ' + valueUnit);
                });
                A.all('.intemp').each(function () {
                    var value = json.intemp.replace(',', '.');
                    var valueUnit = json.tempunit;
                    this.html(value + ' ' + valueUnit);
                });
                A.all('.hum').each(function () {
                    var value = json.hum.replace(',', '.');
                    var valueUnit = '%';
                    this.html(value + ' ' + valueUnit);
                });
                A.all('.inhum').each(function () {
                    var value = json.inhum.replace(',', '.');
                    var valueUnit = '%';
                    this.html(value + ' ' + valueUnit);
                });
                A.all('.wspeed').each(function () {
                    var value = json.wgust.replace(',', '.');
                    var valueUnit = json.windunit;
                    this.html(value + ' ' + valueUnit);
                });
                A.all('.currentwdir').each(function () {
                    var value = json.wgust.replace(',', '.');
                    var valueUnit = json.windunit;
                    this.html(value + ' ' + valueUnit);
                });
                A.all('.rhour').each(function () {
                    var value = json.rhour.replace(',', '.');
                    var valueUnit = json.rainunit;
                    this.html(value + ' ' + valueUnit);
                });
                A.all('.timehhmmss').each(function () {
                    var value = json.timehhmmss;
                    this.html(value);
                });
            }
        }
);