package backend

class Company {
    String name
    String toString() {
        this.name
    }

    Segment segment
    /*static hasMany = [ segment : Segment ]

    static mapping = {
        segment joinTable: [name: 'segment',
                              key: 'id',
                              column: 'name',
                              type: "text"]
    }*/

    /*static mapping = {
        segment column: 'segment_id'
    }*/

    static mapping = {
        segment column: 'segment_id'
        columns {
            mainBranch {
                column name: "name"
            }
        }
    }
}
