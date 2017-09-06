package breadcrumbs

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/user"(resources: "user"){
            "/location"(resources: "location")
            "/role"(resources: "role")
            "/article"(resources: "article")
        }

        "/location"(resources: "location"){
            "/user"(resources: "user")
        }

        "/article"(resources: "article"){
            "/user"(resources: "user")
            "/tag"(resources: "tag")
            "/comment"(resources: "comment"){
                "/user"(resources: "user")
            }

        }

        "/comment"(resources: "comment"){
            "/user"(resources: "user")
        }

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
