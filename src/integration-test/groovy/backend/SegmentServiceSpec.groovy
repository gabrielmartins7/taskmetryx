package backend

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SegmentServiceSpec extends Specification {

    SegmentService segmentService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Segment(...).save(flush: true, failOnError: true)
        //new Segment(...).save(flush: true, failOnError: true)
        //Segment segment = new Segment(...).save(flush: true, failOnError: true)
        //new Segment(...).save(flush: true, failOnError: true)
        //new Segment(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //segment.id
    }

    void "test get"() {
        setupData()

        expect:
        segmentService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Segment> segmentList = segmentService.list(max: 2, offset: 2)

        then:
        segmentList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        segmentService.count() == 5
    }

    void "test delete"() {
        Long segmentId = setupData()

        expect:
        segmentService.count() == 5

        when:
        segmentService.delete(segmentId)
        sessionFactory.currentSession.flush()

        then:
        segmentService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Segment segment = new Segment()
        segmentService.save(segment)

        then:
        segment.id != null
    }
}
