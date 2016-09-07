package demo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@Mock([Address, Person])
class BindingIdToDomainClassReferenceSpec extends Specification {

    void "test id binding"() {
        setup:
        new Address(town: 'Town One').save()
        new Address(town: 'Town Two').save()
        new Address(town: 'Town Three').save()

        expect:
        new Person(homeAddress: addressId).homeAddress.town == townName

        where:
        addressId | townName
        1         | 'Town One'
        2         | 'Town Two'
        3         | 'Town Three'
    }
}
