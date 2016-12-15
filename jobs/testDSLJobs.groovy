import groovy.json.JsonSlurper

String basePath = 'DSL-Test-Job'
String repo = 'rewatiramangautam/ansible-jenkins-dsl'
//https://git.nbnco.net.au/rewatiramangautam/ansible-jenkins-dsl.git

// folder(basePath) {
//     description 'This example shows how to create a set of jobs for each github branch, each in its own folder.'
// }
URL branchUrl = "https://git.nbnco.net.au/$repo/branches".toURL()
List branches = new JsonSlurper().parse(branchUrl.newReader())

branches.each { branch ->

    String safeBranchName = branch.name.replaceAll('/', '-')

    // folder "$basePath/$safeBranchName"

    job("$basePath") {
         parameters {
             stringParam('MESSAGE', 'Hello world!') 
        }

        scm {
            gitlab repo, branch.name
        }
        triggers {
            scm 'H/30 * * * *'
        }
        steps {
            shell('echo $MESSAGE')
        }
        steps {
        ansiblePlaybook('/jobs/ansible/DSL.yml') {
        ansibleName('2.2.0.0')
        sudo(true)
    }
}
    }

}