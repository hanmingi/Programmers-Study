# Implementing FAT File System

FAT 파일 시스템 구현 과제


1st : FAT Table 구현

2nd : Buffer Cache 구현

3rd : File System 구현


 # 3rd 구현 함수
 파일을 다루는 API를 직접 구현한다.
 
 - Format
 
 파일 시스템을 포맷하고 초기화하는 동작을 수행한다. 가상 디스크를 초기화하고 file system info를 초기화한다.
 
 - Mount
 
 포맷 대신 가상 디스크를 open하는 동작만 수행한다. 
 
 - Unmount
 
 Buffer cache에 저장된 dirty block들을 디스크로 저장한 후에, 가상 디스크를 close 한다. 
 
 이때 BufSync()를 사용한다. 
          
 마지막으로 가상 디스크 파일을 close한다.
 
 
 차후 추가 함수 : OpenFile, ReadFile, WriteFile, CloseFile, MakeDir, RemoveDir, etc
