package dev.melik.bootcamp.week4.q2.controller.movie;

import dev.melik.bootcamp.week4.q2.BaseIntegrationTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import dev.melik.bootcamp.week4.q2.controller.actor.ActorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MovieControllerTest extends BaseIntegrationTest {

    @Test
    @Sql(scripts = "/insert-movies.sql" ,executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/clean-tables.sql" ,executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_retrieve_movie(){

        //when
        ResponseEntity<MovieResponse>response=testRestTemplate.getForEntity("/movies/3",MovieResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        MovieResponse movieResponse=response.getBody();
        assertThat(movieResponse)
                .extracting("id","name","genre","releaseYear","director")
                .containsExactly(3L,"Movie 3",MovieGenre.ACTION,2000,"Best Director");

    }

    @Test
    @Sql(scripts = "/insert-movies.sql" ,executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/clean-tables.sql" ,executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_retrieve_actors_of_movie() throws ParseException {

        ResponseEntity<ActorResponse[]> response=testRestTemplate.getForEntity("/movies/3/actors",ActorResponse[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        assertThat(response.getBody().length).isEqualTo(2);
        assertThat(response.getBody())
                .extracting("id","name","birthDate")
                .containsExactly(
                        tuple(2L,"Actor 2", new SimpleDateFormat("yyyy-MM-dd").parse("1999-01-01")),
                        tuple(3L,"Actor 3", new SimpleDateFormat("yyyy-MM-dd").parse("1998-01-01"))
                );


    }
}
