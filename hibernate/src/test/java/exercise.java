public class exercise {


    //一对多
    /*
    配置文件
    一 ：

            <class name table>
           id
          property
          <set>  <one-to-many name="多 对应的 " class casecade inverse >//错误
           </set>

           <set name = "多的set" cascade inverse>
           <key 对应列  column = "xxx" 数据库的列名 /> //正确
           <one-to-many class="类名">
           </set>
        </class>

       多：

        <one-to-many class = "类名"/>错误

        <many-to-one name =""  column = "数据库列名  与"一 "对应" fetch = join //作用  避免N+1/>
     */

    //一对一
    /*
    主：配置文件
        <one-to-one name class column >//没有column


    从：
        <id name >
        <generator name="foreign" >
        <param name = "property">类的对象</param>
        </generator>
        </id>

        <one-to-one name class >

    */
}
