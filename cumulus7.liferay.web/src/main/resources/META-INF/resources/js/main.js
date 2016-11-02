AUI().ready('node', 'transition', 'aui-image-viewer', 'aui-io-request',
        function (A) {
            A.all('.portlet-cumulus-charts').each(function () {
                setChartsAnim(A, this);
            });

            A.all('.update-json-link').each(function () {
                this.on('click',
                        function () {
                            updateJSONValues(A);
                        });
            });

            A.on('load',
                    function () {
                        updateJSONValues(A);
                        setInterval(function () {
                            updateJSONValues(A);
                        }, 300000);
                    }
            );
        }
);
/*
 * Update all elements with attribute data-json="key in json file" wrapperd by
 * div element of class json-block-url and attribute data-href="link to json file"
 * Use data-unit="literal to append" when the data needs to append units.
 */
function updateJSONValues(A) {
    A.all('div.json-block-url').each(function () {
        var div = this;
        A.io.request(div.getAttribute('data-href'), {
            dataType: 'json',
            on: {
                success: function () {
                    var json = this.get('responseData');
                    div.all('[data-json]').each(function () {
                        var text = '';
                        if (json[this.getAttribute('data-json')] !== undefined) {
                            text += json[this.getAttribute('data-json')];
                            if (this.getAttribute('data-unit') !== undefined) {
                                text += ' ' + this.getAttribute('data-unit');
                            }
                            this.html(text);
                        }
                    });
                }
            }
        });
    });
}

function setChartsAnim(A, portletNode) {
    var imgActive = portletNode.one('.chart-img img[alt="temp"]');
    imgActive.show('fadeIn');
    portletNode.all('.chart-thumbs img').on('click',
            function (event) {
                var alt = event.currentTarget.get('alt');
                imgActive.hide('fadeOut',
                        function () {
                            imgActive = portletNode.one('.chart-img img[alt="' + alt + '"]');
                            imgActive.show('fadeIn');
                        });
            });
    var imageViewer = new A.ImageViewer(
            {
                links: portletNode.all('.chart-img div a'),
                infoTemplate: 'Chart {current} of {total}',
                headerContent: '<h3 class="text-center">Weather Charts</h3>',
                circular: true,
                zIndex: 1,
                height: '90%',
                playing: false
            }
    );
    portletNode.all('.chart-img img').on('click',
            function () {
                imageViewer.render();
            });
}