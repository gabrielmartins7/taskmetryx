package backend

import grails.gorm.services.Service

@Service(Segment)
interface SegmentService {

    Segment get(Serializable id)

    List<Segment> list(Map args)

    Long count()

    void delete(Serializable id)

    Segment save(Segment segment)

}