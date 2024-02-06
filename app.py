import os

video_path = "D:\\User\\heima\\3. 微服务"

for fl_name in os.listdir(video_path):
    os.rename(os.sep.join([video_path, fl_name]), os.sep.join([video_path, fl_name.split(' ')[-1]]))


