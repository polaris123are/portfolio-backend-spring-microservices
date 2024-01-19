package com.protfolio.portfolio_service.controllers;

        import java.io.File;
        import java.io.IOException;
        import java.nio.file.Files;

        import java.util.Date;
        import java.util.Optional;


        import com.protfolio.portfolio_service.entities.Image;
        import com.protfolio.portfolio_service.repositories.ImageReposetory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;

        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/image")
public class ImageController{
    public static String UPLOAD_DIRECTORY ="C:\\Users\\Dell\\Documents\\workspace-spring-tool-suite-4-4.17.2.RELEASE\\pfaprojet\\Uploadimages";

    @Autowired
    ImageReposetory imagedatastore;

    @PostMapping
    public Image addimage(@RequestParam("avatar") MultipartFile file) throws IllegalStateException, IOException {
        Image myimageinfo=new Image();
        Date a=new Date();
        String myfilename=UPLOAD_DIRECTORY+"\\"+file.getName()+file.hashCode();
        myimageinfo.setPath(myfilename);
        file.transferTo(new File(myfilename));
        return imagedatastore.save(myimageinfo);}


    @GetMapping("/{id}")
    public ResponseEntity addimage(@PathVariable("id") Long l ) throws IOException {

        Optional<Image> b = imagedatastore.findById(l);
        Image h = b.get();
        byte[] image = Files.readAllBytes(new File(h.getPath()).toPath());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }
}
