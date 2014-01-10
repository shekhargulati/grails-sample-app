package sampleapp

import grails.rest.Resource

@Resource(uri = "/api/v1/stories",formats = ['json','xml'])
class Story {

    String title
    String url

    static constraints = {
    }
}
