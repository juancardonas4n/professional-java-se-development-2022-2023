# Diego Giraldo

## Printer System

* email: giraldiego@gmail.com
* repository: no one
* Current commit:
```shell
```

## Criterias
| Criteria                                | Description                                                  | Points |
| :-------------------------------------- | ------------------------------------------------------------ | ------ |
| **Requirement for the system**          | Both requirements (functional and non-functional) are defined in the document. | 7      |
| **Use cases**                           | The use cases follow the requirements of the system. But, its context is too particular. Usually, a reservation system is used for other objects such as rooms, TACS, etc. | 7      |
| **Objects, classes, and relationships** | Objects and classes are identified from the use cases.       | 8      |
| **Class diagrams**                      | The diagram corresponds to objects and classes identified in the previous point, but the class diagram doesn't show all relationships or identify the correct cardinality between the classes. | 4      |

## Notes

* Requirement for the system ![image-20230201122434217](/home/juancardona/Workbench/professional-java-se-development-2022-2023/images/image-20230201122434217.png)
* Use cases 1![image-20230201123319205](/home/juancardona/Workbench/professional-java-se-development-2022-2023/images/image-20230201123319205.png)
* Use case 2 ![image-20230201123512034](/home/juancardona/Workbench/professional-java-se-development-2022-2023/images/image-20230201123512034.png)
* Objects, classes and relationships 1![image-20230201124101656](/home/juancardona/Workbench/professional-java-se-development-2022-2023/images/image-20230201124101656.png)
* Objects, classes and relationships 2![image-20230201124132880](/home/juancardona/Workbench/professional-java-se-development-2022-2023/images/image-20230201124132880.png)
* Class diagram![image-20230201134525687](/home/juancardona/Workbench/professional-java-se-development-2022-2023/images/image-20230201134525687.png)
* Next time you can use [pandoc](https://pandoc.org/) to generate the final document.
* It is something strange to use a reservation schema with printers, because such systems require a previous setup before lending the printer to the user, and require a list of parameters, such as the kind of papers; the number of sheets, printer setup on the user's pc, etc. 
* The class diagram doesn't reflect the consequences of the model, if your system is the printer reservation you have to manage more information about the state, for instance: lending, maintenance, etc. You need to keep the information about the staff that classified the printer's status and check every time the printer is returned.
