package com.sakila.sakilaproject.services;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.tools.agent.ReactorDebugAgent;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoServicesTest {

    FluxAndMonoServices fluxAndMonoServices
            = new FluxAndMonoServices();

    @Test
    void fruitsFlux() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFlux();

        StepVerifier.create(fruitsFlux)
                .expectNext("Mango","Orange","Banana")
                .verifyComplete();
    }

    @Test
    void fruitMono() {
        Mono<String> fruitsMono = fluxAndMonoServices.fruitMono();

        StepVerifier.create(fruitsMono)
                .expectNext("Mango")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxMap();

        StepVerifier.create(fruitsFlux)
                .expectNext("MANGO","ORANGE","BANANA")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFilter() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxFilter(5).log();

        StepVerifier.create(fruitsFlux)
                .expectNext("Orange","Banana")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFilterMap() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxFilterMap(5);

        StepVerifier.create(fruitsFlux)
                .expectNext("ORANGE","BANANA")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFlatMap() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxFlatMap();

        StepVerifier.create(fruitsFlux)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitsFluxFlatMapAsync() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxFlatMapAsync();

        StepVerifier.create(fruitsFlux)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitMonoFlatMap() {
        Mono<List<String>> fruitsFlux = fluxAndMonoServices.fruitMonoFlatMap();

        StepVerifier.create(fruitsFlux)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void fruitsFluxConcatMap() {

        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxConcatMap();

        StepVerifier.create(fruitsFlux)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitMonoFlatMapMany() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitMonoFlatMapMany();

        StepVerifier.create(fruitsFlux)
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransform() {

        Flux<String> fruitsFlux
                = fluxAndMonoServices.fruitsFluxTransform(10);

        StepVerifier.create(fruitsFlux)
                .expectNext("Orange","Banana")
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransformDefaultIfEmpty() {
        Flux<String> fruitsFlux
                = fluxAndMonoServices.fruitsFluxTransformDefaultIfEmpty(10);

        StepVerifier.create(fruitsFlux)
                .expectNext("Default")
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransformSwitchIfEmpty() {
        Flux<String> fruitsFlux
                = fluxAndMonoServices.fruitsFluxTransformSwitchIfEmpty(8);

        StepVerifier.create(fruitsFlux)
                .expectNext("Pineapple","Jack Fruit")
                .verifyComplete();

    }

    @Test
    void fruitsFluxConcat() {

        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxConcat().log();
        StepVerifier.create(fruitsFlux)
                .expectNext("Mango","Orange","Tomato","Lemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxConcatWith() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxConcatWith().log();
        StepVerifier.create(fruitsFlux)
                .expectNext("Mango","Orange","Tomato","Lemon")
                .verifyComplete();
    }

    @Test
    void fruitsMonoConcatWith() {

        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsMonoConcatWith().log();
        StepVerifier.create(fruitsFlux)
                .expectNext("Mango","Tomato")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMerge() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxMerge().log();
        StepVerifier.create(fruitsFlux)
                .expectNext("Mango","Tomato","Orange","Lemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMergeWith() {
        Flux<String> fruitsFlux = fluxAndMonoServices.fruitsFluxMergeWith().log();
        StepVerifier.create(fruitsFlux)
                .expectNext("Mango","Tomato","Orange","Lemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMergeWithSequential() {
        Flux<String> fruitsFlux = fluxAndMonoServices
                .fruitsFluxMergeWithSequential().log();
        StepVerifier.create(fruitsFlux)
                .expectNext("Mango","Orange","Tomato","Lemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxZip() {
        Flux<String> fruitsFlux = fluxAndMonoServices
                .fruitsFluxZip().log();
        StepVerifier.create(fruitsFlux)
                .expectNext("MangoTomato","OrangeLemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxZipWith() {
        Flux<String> fruitsFlux = fluxAndMonoServices
                .fruitsFluxZipWith().log();
        StepVerifier.create(fruitsFlux)
                .expectNext("MangoTomato","OrangeLemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxZipTuple() {
        Flux<String> fruitsFlux = fluxAndMonoServices
                .fruitsFluxZipTuple().log();
        StepVerifier.create(fruitsFlux)
                .expectNext("MangoTomatoPotato","OrangeLemonBeans")
                .verifyComplete();
    }

    @Test
    void fruitsMonoZipWith() {

        Mono<String> fruitsFlux = fluxAndMonoServices
                .fruitsMonoZipWith().log();
        StepVerifier.create(fruitsFlux)
                .expectNext("MangoTomato")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFilterDoOn() {
        Flux<String> fruitsFlux = fluxAndMonoServices
                .fruitsFluxFilterDoOn(5).log();

        StepVerifier.create(fruitsFlux)
                .expectNext("Orange","Banana")
                .verifyComplete();
    }

    @Test
    void fruitsFluxOnErrorReturn() {
        Flux<String> fruitsFlux = fluxAndMonoServices
                .fruitsFluxOnErrorReturn().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("Apple","Mango","Orange")
                .verifyComplete();
    }

    @Test
    void fruitsFluxOnErrorContinue() {
        Flux<String> fruitsFlux = fluxAndMonoServices
                .fruitsFluxOnErrorContinue().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("APPLE","ORANGE")
                .verifyComplete();
    }

    @Test
    void fruitsFluxOnErrorMap() {
        //Hooks.onOperatorDebug();
        ReactorDebugAgent.init();
        ReactorDebugAgent.processExistingClasses();
        Flux<String> fruitsFlux = fluxAndMonoServices
                .fruitsFluxOnErrorMap().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("APPLE")
                .expectError(IllegalStateException.class)
                .verify();
    }

    @Test
    void fruitsFluxOnError() {
        Flux<String> fruitsFlux = fluxAndMonoServices
                .fruitsFluxOnError().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("APPLE")
                .expectError(RuntimeException.class)
                .verify();
    }
}