               <script type="text/javascript">
                   
                        // This script change the rotation interval of carousel. And pause it when mouse is over.
			window.onload = function()
			{
				$('#myCarousel').carousel({
					pause: 'hover',
					interval: 5000
				},'cycle')
			}
			
                        // This script change "hide" to "Show" on said buttons when clicked.
			$('button').click(function(){
				$('this').closest('div').find('div').toggle();
				var currentText = $.trim($(this).text());
				if('Hide' == currentText){
					$(this).text('Show');
				}else if('Show' == currentText){
					$(this).text('Hide');
				}
			});
			
		</script>