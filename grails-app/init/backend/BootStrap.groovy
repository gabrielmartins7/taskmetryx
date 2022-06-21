package backend

class BootStrap {
    SegmentService segmentService
    CompanyService companyService

    def init = { servletContext ->
        Segment segment1 = new Segment(name: 'vehicles')
        Segment segment2 = new Segment(name: 'truck')
        /*Company company1 = new Company(name: 'Nissan')*/
        companyService.save(new Company(name: 'Nissan', segment: segment1))
        companyService.save(new Company(name: 'Ford', segment: segment2))
        companyService.save(new Company(name: 'Fiat', segment: segment1))
    }
    def destroy = {
    }
}
