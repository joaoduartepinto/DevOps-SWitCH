version = "2020.2"

project {

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root()
    }
})
