<template>
  <div>
  <el-container>
    <el-header  style="text-align: left; font-size: 30px ;align-items: center;padding: 0px" >
      <el-button type="primary" size="mini" icon="el-icon-plus"  @click="addemp">添加</el-button>
      <el-button type="success" size="mini"  icon="el-icon-download"  @click="dialogVisible = true">导出</el-button>
      <el-button type="success" size="mini"  icon="el-icon-upload"  @click="dialogVisible = true">导入</el-button>
    </el-header>
    <el-main>
      <el-table :data="tableDatas" border stripe style="width: 100%" v-loading="tableLoading">
        <el-table-column type="selection" align="left" width="30"></el-table-column>
        <el-table-column fixed align="left" prop="name" label="员工姓名" width="180"></el-table-column>
        <el-table-column align="left"  label="调薪日期" width="180" ><template slot-scope="scope">{{scope.row.asDate|formatDate}}</template></el-table-column>
        <el-table-column align="left" prop="beforeSalary" label="调薪前薪资"></el-table-column>
        <el-table-column align="left" prop="afterSalary" label="调薪后薪资"></el-table-column>
        <el-table-column align="left" prop="reason" label="调薪原因"></el-table-column>
        <el-table-column fixed="right" label="操作" width="150">
          <template slot-scope="scope">
            <el-button @click="showTableContent(scope.row)" type="text" size="small">查看</el-button>
            <el-button @click="editTableContent(scope.row)" type="text" size="small">编辑</el-button>
            <el-button type="text" size="small" style="color: red">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
    <el-dialog title="调薪明细" :visible.sync="dialogVisible" width="50%" >
        <el-form :model="tableData" ref="addEmpForm">
          <el-row>

              <el-form-item label="员工姓名" prop="name">
                <!--<el-input v-model="tableData.name" prefix-icon="el-icon-edit"  style="width: 50%":disabled="disState"></el-input>-->
                <el-select v-model="tableData.name" placeholder="请选择">
                  <el-option v-for="item in userList":key="item.id":label="item.name":value="item.id":disabled="disState">

                  </el-option>
                </el-select>
              </el-form-item>

              <el-form-item label="调薪时间" >
                  <el-date-picker type="date" placeholder="选择日期" v-model="tableData.ssDate" style="width: 50%":disabled="disState"></el-date-picker>
              </el-form-item>


          <el-form-item label="调前薪资">
            <el-input v-model="tableData.beforeSalary" style="width: 50%":disabled="disState"></el-input>
          </el-form-item>

          <el-form-item label="调后薪资" >
            <el-input v-model="tableData.afterSalary"  style="width: 50%":disabled="disState"></el-input>
          </el-form-item>

            <el-form-item label="调整原因" >
              <el-input  type="textarea"   v-model="tableData.reason"  style="width: 50%":disabled="disState"></el-input>
            </el-form-item>

      </el-row>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addTableContent('addEmpForm')":style="{display:playState}">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<style>
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>
<script>
  export default {
    data() {
      return {
        tableDatas: [],
        userList:[],
        playState:'',
        dialogVisible: false,
        disState:false,
        tableLoading:false,
        tableData: {
          name:'',
          id:'',
          eid:'',
          afterSalary:'',
          beforeSalary:'',
          reason:'',
          remark:'',
          asDate:''
        },
        userList:{
          name:'',
          id:''
        }
      }
    },
    methods: {
      tableRowClassName({row, rowIndex}) {
        if (rowIndex === 1) {
          return 'warning-row';
        } else if (rowIndex === 3) {
          return 'success-row';
        }
        return '';
      },
      loadSalary(){
        var _this = this;
        this.tableLoading = true;
        this.getRequest("/salary/adjust/list").then(resp=> {
          this.tableLoading = false;
          if (resp && resp.status == 200) {
            var data = resp.data;
            _this.tableDatas = data.dataTable;
            console.log(data.dataTable);
          }
        })
      },
      handleChange(value) {
        console.log(value);
      },
      showTableContent(row){
        this.tableData=row;
        this.tableData.name=row.name;
        this.tableData.reason=row.reason;
        this.tableData.ssDate=row.asDate;
        this.tableData.afterSalary=row.afterSalary;
        this.tableData.beforeSalary=row.beforeSalary;
        this.dialogVisible = true;
        this.disState=true;
        this.playState="none";
      },
      editTableContent(row){
        this.tableData=row;
        this.tableData.name=row.name;
        this.tableData.reason=row.reason;
        this.tableData.ssDate=row.asDate;
        this.tableData.afterSalary=row.afterSalary;
        this.tableData.beforeSalary=row.beforeSalary;
        this.dialogVisible = true;
        this.disState=false;
        this.playState="";
        //this.playState="none";
      },
      addemp(){
        this.tableData="";
        this.dialogVisible=true;
        this.disState=false;
        this.playState="";
      },
      addTableContent(formName){
        var _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if (this.tableData.id) {
              //更新
              this.tableLoading = true;
              this.postRequest("/salary/adjust/update", this.tableData).then(resp=> {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;
                  _this.dialogVisible = false;
                  _this.loadSalary();
                }
              })
            } else {
              //添加
              this.tableLoading = true;
              this.postRequest("/salary/adjust/add", this.emp).then(resp=> {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;

                  _this.dialogVisible = false;
                  _this.loadSalary();
                }
              })
            }
          } else {
            return false;
          }
        });
      }
    },
    mounted:function () {
      this.loadSalary();
    }
  }
</script>
