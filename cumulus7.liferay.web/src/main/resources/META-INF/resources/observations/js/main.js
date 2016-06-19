AUI().ready(
        'node',
        'liferay-portlet-url',
        'aui-io-request',
        'aui-progressbar',
        function (A) {
            var jsonURL = A.one('.observations-json-link').getAttribute('data-href');
            if (jsonURL) {
                A.all('.observations-json-link').each(
                        function () {
                            this.on('click',
                                    function () {
                                        getJSON(jsonURL);
                                    });
                        });
                A.on('load',
                        function () {
                            getJSON(jsonURL);
                            setInterval(function () {
                                getJSON(jsonURL);
                            }, 180000);
                        }
                );
            }
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
                // EXTERIOR TEMPERATURE
                updateTemp(json);
                // INTERIOR TEMPERATURE
                updateInTemp(json);
                // EXTERIOR HUMIDITY
                updateHum(json);
                // INTERIOR HUMIDITY
                updateInHum(json);
                // WIND SPEED
                updateWindSpeed(json);
                // CURRENT WIND DIRECTION
                updateWindDirection(json);
                // RAINFALL LAST HOUR
                updateRainFall(json);
                // TIME
                updateTime(json);
            }
            function updateTemp(json) {
                A.all('.temp').each(function () {
                    var value = json.temp.replace(',', '.');
                    var valueUnit = json.tempunit;
                    this.html(value + ' ' + valueUnit);
                });
            }
            function updateInTemp(json) {
                A.all('.intemp').each(function () {
                    var value = json.intemp.replace(',', '.');
                    var valueUnit = json.tempunit;
                    this.html(value + ' ' + valueUnit);
                });
            }
            function updateHum(json) {
                A.all('.hum').each(function () {
                    var value = json.hum.replace(',', '.');
                    var valueUnit = '%';
                    this.html(value + ' ' + valueUnit);
                });
            }
            function updateInHum(json) {
                A.all('.inhum').each(function () {
                    var value = json.inhum.replace(',', '.');
                    var valueUnit = '%';
                    this.html(value + ' ' + valueUnit);
                });
            }
            function updateWindSpeed(json) {
                A.all('.wspeed').each(function () {
                    var value = json.wgust.replace(',', '.');
                    var valueUnit = json.windunit;
                    this.html(value + ' ' + valueUnit);
                });
            }
            function updateWindDirection(json) {
                A.all('.currentwdir').each(function () {
                    var value = json.wgust.replace(',', '.');
                    var valueUnit = json.windunit;
                    this.html(value + ' ' + valueUnit);
                });
            }
            function updateRainFall(json) {
                A.all('.rhour').each(function () {
                    var value = json.rhour.replace(',', '.');
                    var valueUnit = json.rainunit;
                    this.html(value + ' ' + valueUnit);
                });
            }
            function updateTime(json) {
                A.all('.timehhmmss').each(function () {
                    var value = json.timehhmmss;
                    this.html(value);
                });
            }
        }
);