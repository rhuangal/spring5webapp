package com.rhuangal.spring5webapp.bootstrap;

import com.rhuangal.spring5webapp.model.Author;
import com.rhuangal.spring5webapp.model.Book;
import com.rhuangal.spring5webapp.model.Publisher;
import com.rhuangal.spring5webapp.repository.AuthorRepository;
import com.rhuangal.spring5webapp.repository.BookRepository;
import com.rhuangal.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher pl = new Publisher();
        pl.setName("Punto de Lectura");

        Publisher af = new Publisher();
        af.setName("Alfaguara");

        publisherRepository.save(pl);
        publisherRepository.save(af);

        //Mario Vargas LLosa
        Author mvargas = new Author("Mario", "Vargas Llosa");
        Book  cp = new Book("La ciudad y los perros", "8466309152", pl);
        mvargas.getBooks().add(cp);
        cp.getAuthors().add(mvargas);

        authorRepository.save(mvargas);
        bookRepository.save(cp);


        //Alfredo Bryce Echenique
        Author abryce = new Author("Alfredo", "Bryce Echenique");
        Book mj = new Book("Un mundo para Julius", "6124039710", af );
        abryce.getBooks().add(mj);
        mj.getAuthors().add(abryce);

        authorRepository.save(abryce);
        bookRepository.save(mj);


    }


}
