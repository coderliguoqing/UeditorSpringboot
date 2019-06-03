# UeditorSpringboot
this is ueditor controller demo project.

### 说明  
  后端部分的重点在于处理文件上传，文件上传部分需要自己动手改写代码，对接自己的文件服务或者存储，总之该DEMO中的代码没有对最终存储这一步做处理；
  你需要修改的代码的位置为 `cn.com.lee.common.ueditor.upload.StorageManager` 类下的TODO：
  ```java
  public static State saveFileByInputStream(HttpServletRequest request, InputStream is, String path, String picName,
			long maxSize) {
		
		State state = null;
		File tmpFile = getTmpFile();
		byte[] dataBuf = new byte[ 2048 ];

		try {
			//转成字节流
			ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
	        int rc = 0;  
	        while ((rc = is.read(dataBuf, 0, 100)) > 0) {  
	            swapStream.write(dataBuf, 0, rc);  
	        }
	        
	        dataBuf = swapStream.toByteArray();
	        swapStream.flush();
	        swapStream.close();

			if (tmpFile.length() > maxSize) {
				tmpFile.delete();
				return new BaseState(false, AppInfo.MAX_SIZE);
			}
			//:TODO
			/**
			 * 此处调用文件上传服务，并获取返回结果返回
			 */
      //UploadResult result = baseFileService.upload(dataBuf, picName, "OM", null);
			
			boolean success = true;
			//如果上传成功
			if (success) {
				state = new BaseState(true);
				state.putInfo( "size", tmpFile.length() );
				state.putInfo( "title", "");//文件名填入此处
				state.putInfo( "url", "");//文件访问的url填入此处
				tmpFile.delete();
			}else{
				state = new BaseState(false, 4);
				tmpFile.delete();
			}

			return state;
			
		} catch (IOException e) {
		}
		return new BaseState(false, AppInfo.IO_ERROR);
	}
  ```
  最终返回的URL地址必须是HTTP、HTTPS开头的网络地址，如果不是请在返回之前做好处理；
