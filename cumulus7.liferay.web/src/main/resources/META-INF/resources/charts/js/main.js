AUI().ready(
        'aui-node',
        'transition',
        'aui-image-viewer',
        function (A) {
            // Charts Portlet
            var imgActive = A.one('.portlet-cumulus-charts .chart-img img[alt="temp"]');
            imgActive.show('fadeIn');
            A.all('.portlet-cumulus-charts .chart-thumbs img').on('click',
                    function (event) {
                        var alt = event.currentTarget.get('alt');
                        imgActive.hide('fadeOut',
                                function () {
                                    imgActive = A.one('.portlet-cumulus-charts .chart-img img[alt="' + alt + '"]');
                                    imgActive.show('fadeIn');
                                });
                    });

            var imageViewer = new A.ImageViewer(
                    {
                        links: '.portlet-cumulus-charts .chart-img div a',
                        infoTemplate: 'Chart {current} of {total}',
                        headerContent: '<h3 class="text-center">Weather Charts</h3>',
                        circular: true,
                        zIndex: 1,
                        height: '90%',
                        playing: false
                    }
            );
            A.all('.portlet-cumulus-charts .chart-img img').on('click',
                    function () {
                        imageViewer.render();
                    });
        }
);