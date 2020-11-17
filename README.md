# MultiThreadExample
Bài 2: Viết chương trình quản lý task thực hiện các yêu cầu sau:
- Tạo 1 abstract class BaseWorker với các thông tin: id, name, priority, delayTime và abstract method “run” (class đại diện cho 1 task sẽ cần thực hiện)
-  Giả sử chương trình có hiện 5 loại task: SendRequestTask, UploadTask, GetDataTask, InsertDataLocalTask, DoActionTask. Các task này sẽ extends từ BaseWorker override lại phương thức run, tại phương thức “run” của mỗi task sẽ log ra thông tin taskName của task đó sau 1 khoảng delayTime khác nhau theo từng loại task.
- Khởi 1 danh sách gồm 50 tasks gồm 5 loại task bên trên, mỗi task trong danh sách tương ứng với từng loại task sẽ có priority và delayTime khác nhau.
Giả sử chỉ có thể tạo tối đa 5 luồng để thực hiện 50 tasks nói trên. Xây dựng class ThreadManager để quản lý việc thực thi xong 50 tasks đó, các task sẽ được thực thi theo độ ưu tiên từ cao đên thấp. In ra thông tin sau khi đã thực hiên xong chương trình.
