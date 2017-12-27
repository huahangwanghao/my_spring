1.对于 git tag的使用
git tag -a init-ioc 7cdf5b0a1c4a9fe15cf02db75c41bd5bf31a7521 -m '最简单的ioc0'
选择push的时候 左下角选择,然后点击 当前分支



2.实际应用中我们希望容器来管理bean的创建, 于是我们把bean的初始化放入了BeanFactory中
为了保证扩展性,我们是Extract Interface的方法, 将BeanFactory创建为接口
AbstractBeanFactory和 AutowireCapableBeanFacotry作为实现
