package com.something


import com.bertramlabs.plugins.karman.StorageProvider
import com.bertramlabs.plugins.karman.CloudFile

class AdminController {

	def settings() {
		def sp = StorageProvider.create(provider: 's3', accessKey: "key", secretKey: "secret/5xSLW6g3z8l5ypwPrd")
        def filelist = []
        sp["bucket"].listFiles(prefix:'path/prefix').each { CloudFile file ->
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
