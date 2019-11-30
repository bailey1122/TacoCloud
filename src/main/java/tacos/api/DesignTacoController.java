//package tacos.api;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.hateoas.server.EntityLinks;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import tacos.Taco;
//import tacos.data.TacoRepository;
//
//import java.util.Optional;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//
//
//@RestController
//@RequestMapping(path = "/design",
//                produces = {"application/json"})
//@CrossOrigin(origins = "*")
//public class DesignTacoController {
//    private TacoRepository tacoRepo;
//
//    @Autowired
//    EntityLinks entityLinks;
//
//    public DesignTacoController(TacoRepository tacoRepo) {
//        this.tacoRepo = tacoRepo;
//    }
//
//    @GetMapping("/recent")
//    public Iterable<Taco> recentTacos() {
//        PageRequest page = PageRequest.of(
//                0, 12, Sort.by("createdAt").descending());
//        return tacoRepo.findAll(page).getContent();
//    }
//
////    @GetMapping("/recent")
//////    public Resources<Resource<Taco>> recentTacos() {
////    public Resources<TacoResource> recentTacos() {
////        PageRequest page = PageRequest.of(
////                0, 12, Sort.by("createdAt").descending());
////
////        List<Taco> tacos = tacoRepo.findAll(page).getContent();
////
////        List<TacoResource> tacoResources =
////                new TacoResourceAssembler().toResources(tacos);
////        Resources<TacoResource> recentResources =
////                new Resources<TacoResource>(tacoResources);
////        recentResources.add(
////                linkTo(methodOn(DesignTacoController.class).recentTacos())
////                .withRel("recents"));
////
//////        Resources<Resource<Taco>> recentResources = Resources.wrap(tacos);
//////
//////        recentResources.add(
//////                linkTo(methodOn(DesignTacoController.class).recentTacos())
//////                .withRel("recents"));
//////
//////        recentResources.add(
//////                ControllerLinkBuilder.linkTo(DesignTacoController.class)
//////                                    .slash("recent")
//////                                    .withRel("recents"));
//////        recentResources.add(
//////                new Link("http://localhost:8080/design/recent", "recents"));
////        return recentResources;
////    }
//
//    @GetMapping("/{id}")
//    public Taco tacoById(@PathVariable("id") Long id) {
//        Optional<Taco> optTaco = tacoRepo.findById(id);
//        if (optTaco.isPresent()) {
//            return optTaco.get();
//        }
//        return null;
//    }
//
////    @GetMapping("/{id}")
////    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
////        Optional<Taco> optTaco = tacoRepo.findById(id);
////        if (optTaco.isPresent()) {
////            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
////        }
////        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
////    }
//
//    @PostMapping(consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Taco postTaco(@RequestBody Taco taco) {
//        return tacoRepo.save(taco);
//    }
//}
