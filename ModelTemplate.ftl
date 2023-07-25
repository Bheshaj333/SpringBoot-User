package com.example.models;

public class ${TableName} {
    <#list ColumnNames as column>
        private ${DataTypes[column_index]} ${column};
    </#list>

    <#list ColumnNames as column>
        public ${DataTypes[column_index]} get${column?cap_first}() {
            return ${column};
        }

        public void set${column?cap_first}(${DataTypes[column_index]} ${column}) {
            this.${column} = ${column};
        }
    </#list>
}
