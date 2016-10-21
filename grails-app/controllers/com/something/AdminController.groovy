package com.something


import com.bertramlabs.plugins.karman.StorageProvider
import com.bertramlabs.plugins.karman.CloudFile

class AdminController {

	def settings() {
		def sp = StorageProvider.create(provider: 's3', accessKey: "AKIAJ36MGCGW4TCE6D6Q", secretKey: "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")
        def filelist = []
        sp["aerstone-sift-test"].listFiles(prefix:'path/prefix').each { CloudFile file ->
          InputStream is
          try {
            String name = file.name
            System.out.println("This is the name: " + name)
            filelist << name
            Long length = file.contentLength
            is = file.inputStream
          } finally {
            is.close()
          }
        }
	}

}
