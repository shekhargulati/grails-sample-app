package sampleapp

import grails.rest.RestfulController

class StoryController extends RestfulController{

    static responseFormats = ['json','xml']

    StoryController() {
        super(Story)
    }

    @Override
    @org.grails.plugins.metrics.groovy.Timed
    Object index(Integer max) {
        respond Story.listOrderBySubmittedOn(order: "desc")
    }
}

