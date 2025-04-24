package snippet;

public class Snippet {
	// Forward
		@GetMapping("/forward1")
		public String f1(Model model) {
			log.info("param/forward1...");
			model.addAttribute("f1", "f1Value");
			return "forward:/param/forward2";
		}
		
		@GetMapping("/forward2")
		public String f2(Model model) {
			log.info("param/forward2...");
			model.addAttribute("f2","f2Value");
			return "forward:/param/forward3";
		}
		
		@GetMapping("/forward3")
		public String f3(Model model) {
			log.info("param/forward3...");
			model.addAttribute("f3","f3Value");
			return "forward:/param/forward_result";
		}
		
}

